package com.thiago.testecamel.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.dsl.HttpEndpointBuilderFactory.HttpMethods;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		
		from("direct:search-user")
			.routeId("route.user.search.one")
			.log("Procurando um usuário usando enrich")
			.to("direct:find-user")
			.log("nome do usuário: ${body}");
			//.to("direct:enrich-github-data");
		
		from("direct:find-user")
			.routeId("route.user.search.into.apiUser")
			.log("Entendendo o body: ${body}")
			.setHeader(Exchange.HTTP_METHOD,constant(HttpMethods.GET))
			.toD("http:localhost:8080/api/users/${body}");
			//.log("Veirificando o log depois: ${body}");
		
		from("direct:hello-world")
			.routeId("route.user.test")
			.log("teste de hello world")
			.setHeader(Exchange.HTTP_METHOD,constant(HttpMethods.GET))
			.to("http:localhost:8080/api/users")
			.log("logando o corpo: ${body}");
			//.toD("http:localhost:8080/api/users?exchange=${body.exchange}?method=GET");
		
	}

}
