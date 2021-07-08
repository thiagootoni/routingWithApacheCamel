package com.thiago.testecamel.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.dsl.HttpEndpointBuilderFactory.HttpMethods;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.thiago.testecamel.router.dto.UserDto;

@Component
public class ApplicationRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:search-user")
			.routeId("route.user.search.one")
			.log("Procurando um usuário usando enrich")
			.to("direct:find-user")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					
					String message = exchange.getIn().getBody(String.class);
					
					Gson gson = new Gson(); // Or use new GsonBuilder().create();
					UserDto dto = gson.fromJson(message, UserDto.class); // deserializes json into target2
					
					exchange.getIn().setBody(dto);
				}
			})
			.log("usuário via log: ${body}")
			.log("usuário via log 2: ${body}");
		
		from("direct:find-user")
			.routeId("route.user.search.into.apiUser")
			.log("Entendendo o body via log: ${body}")
			.setHeader(Exchange.HTTP_METHOD,constant(HttpMethods.GET))
			.toD("http:localhost:8080/api/users/${body}");
		
		from("direct:hello-world")
			.routeId("route.user.test")
			.log("teste de hello world")
			.setHeader(Exchange.HTTP_METHOD,constant(HttpMethods.GET))
			.to("http:localhost:8080/api/users")
			.log("logando o corpo: ${body}");
			//.toD("http:localhost:8080/api/users?exchange=${body.exchange}?method=GET");
		
	}

}
