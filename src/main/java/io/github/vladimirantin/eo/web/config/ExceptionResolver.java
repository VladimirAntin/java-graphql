package io.github.vladimirantin.eo.web.config;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Component
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        GraphqlErrorBuilder response = GraphqlErrorBuilder.newError()
                .errorType(ErrorType.INTERNAL_ERROR)
                .message("")
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation());
        if (ex instanceof EntityNotFoundException) {
            response.errorType(ErrorType.NOT_FOUND).message(String.valueOf(ErrorType.NOT_FOUND));
        } else if (ex instanceof ObjectOptimisticLockingFailureException) {
            response.errorType(ErrorType.BAD_REQUEST).message("OPTIMISTIC_LOCK");
        } else if (ex instanceof EntityExistsException) {
            response.errorType(ErrorType.BAD_REQUEST).message("ENTITY_EXISTS");
        }
        return response.build();
    }

}
