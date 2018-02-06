package com.pce;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.ExpiringSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.stereotype.Component;

import com.pce.domain.Partner;
import com.pce.repository.PartnerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * {@code
 *  curl --noproxy localhost -u user:password -v http://localhost:8080/api/auth
 *  export AUTH_TOKEN=...
 *  curl --noproxy localhost -H "x-auth-token: $AUTH_TOKEN" -v http://localhost:8080/api/greet
 *  curl --noproxy localhost -H "x-auth-token: $AUTH_TOKEN" -v -d "amount=42.0"  http://localhost:8080/api/order
 *  curl --noproxy localhost -H "x-auth-token: $AUTH_TOKEN" -v -d "amount=1000.0"  http://localhost:8080/api/order
 *  
 *  curl --noproxy localhost -u admin:password -v http://localhost:8080/api/auth
 *  export AUTH_TOKEN=...
 *  curl --noproxy localhost -H "x-auth-token: $AUTH_TOKEN" -v -d "amount=1000.0"  http://localhost:8080/api/order
 *  }
 * </pre>
 *
 */
@SpringBootApplication
public class SpringBootStandAloneWarApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandAloneWarApp.class, args);
	}
}

@Configuration
@EnableSpringHttpSession
class HttpSessionConfig {

	@Bean
	SessionRepository<ExpiringSession> inmemorySessionRepository() {
		return new MapSessionRepository();
	}

	@Bean
	HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig extends GlobalMethodSecurityConfiguration {

	@Autowired
	private DomainAwarePermissionEvaluator permissionEvaluator;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {

		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(permissionEvaluator);
		expressionHandler.setApplicationContext(applicationContext);

		return expressionHandler;
	}
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PartnerRepository repository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
				.anyRequest().authenticated() //
				.and().requestCache().requestCache(new NullRequestCache()) //
				.and().httpBasic() //
				.and().csrf().disable();
		
//		http
//		.authorizeRequests()
//			.antMatchers("/resources/**", "/signup", "/about").permitAll()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//			.anyRequest().authenticated()
//			.and()
//		.formLogin();
	}

	@Autowired
	void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		Iterable<Partner> partners = repository.findAll();
		if(partners == null) {
//			partners.
		}
		for(Partner partner : partners) {
			auth.inMemoryAuthentication().withUser(partner.getUserName()).password(partner.getPassword()).authorities(partner.getRole());
		}
//		auth.inMemoryAuthentication() //
//				.withUser("user").password("password").authorities("ROLE_USER") //
//				.and() //
//				.withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN");
	}
}

@Slf4j
@Component
class DomainAwarePermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//		log.info("check permission '{}' for user '{}' for target '{}'", permission, authentication.getName(),
//				targetDomainObject);
		if ("place-order".equals(permission)) {
//			Order order = (Order) targetDomainObject;
//			if (order.getAmount() > 500) {
//				return hasRole("ROLE_ADMIN", authentication);
//			}
		}
		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return hasPermission(authentication, new Partner(), permission);
	}

//	private boolean hasRole(String role, Authentication auth) {
//		if (auth == null || auth.getPrincipal() == null) {
//			return false;
//		}
//		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
//		if (CollectionUtils.isEmpty(authorities)) {
//			return false;
//		}
//		return authorities.stream().filter(ga -> role.equals(ga.getAuthority())).findAny().isPresent();
//	}

}

//@RequestMapping("/api/auth")
//@RestController
//class AuthEndpoint {
//
//	@GetMapping
//	Map<String, Object> getToken(HttpSession session) {
//		return Collections.singletonMap("session", session.getId());
//	}
//}
//
//@Secured("ROLE_USER")
//@RequestMapping("/api/greet")
//@RestController
//class GreetingEndpoint {
//
//	@GetMapping
//	Map<String, Object> greet(@AuthenticationPrincipal Principal user) {
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("user", user.getName());
//		return map;
//	}
//}
//
//@Secured("ROLE_USER")
//@RequestMapping("/api/order")
//@RestController
//class OrderEndpoint {
//
//	@PostMapping
//	@PreAuthorize("hasPermission(#order, 'place-order')")
//	Map<String, Object> greet(Order order) {
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("orderId", UUID.randomUUID());
//		return map;
//	}
//}
//
//@Data
//class Order {
//	double amount;
//}
//
//@RequestMapping("/api/admin")
//@RestController
//class AdminEndpoint {
//
//	@GetMapping
//	@Secured("ROLE_ADMIN")
//	Map<String, Object> manage(@AuthenticationPrincipal Principal user) {
//		return Collections.singletonMap("user", user.getName());
//	}
//}