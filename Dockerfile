FROM public.ecr.aws/lambda/java:11

# Copy function code and runtime dependencies from Maven layout
COPY HelloWorldFunction/target/classes ${LAMBDA_TASK_ROOT}
# COPY HelloWorldFunction/target/dependency/* ${LAMBDA_TASK_ROOT}/lib/

# Set the CMD to your handler (could also be done as a parameter override outside of the Dockerfile)
CMD [ "helloworld.App::handleRequest" ]
