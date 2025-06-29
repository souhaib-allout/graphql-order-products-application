package org.example.graphqlordersmanagment.configs;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLValidationExceptionResolver implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof ConstraintViolationException validationEx) {
            List<GraphQLError> errors = validationEx.getConstraintViolations()
                    .stream()
                    .map(violation -> GraphqlErrorBuilder.newError(env)
                            .message(violation.getPropertyPath() + ": " + violation.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .build())
                    .collect(Collectors.toList());

            return Mono.just(errors);
        }
        return Mono.empty();
    }
}
