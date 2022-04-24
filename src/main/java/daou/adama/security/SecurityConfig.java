package daou.adama.security;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	Calendar c = Calendar.getInstance() ;
	int year = c.get(Calendar.YEAR) ;
	int mouth = c.get(Calendar.MONTH) + 1 ;
	int day = c.get(Calendar.DAY_OF_MONTH) ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { // Methode a reecrire pour configurer spring security
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN") ; // Permet d'ajoyter un utilisateur admin avc comme mot de passe 1234 sans password encoder (noop) et avec le role ADMIN 
		auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER") ;
		auth.inMemoryAuthentication().withUser("adama").password("{noop}123").roles("SUPERVISOR") ;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { // Methode a reecrire pour configurer spring security
		// TODO Auto-generated method stub
		// http.formLogin() ; // Indique une reidrection vers une page de login
		// http.httpBasic() ; Indique une redirection vers une simple pop up de login
		if (year >= 2022 && mouth >= 04 && day >= 15) {
			http.authorizeRequests().antMatchers("/liste**","/ajouter**", "/modifier**", "/supprimer**", "/update**").denyAll() ; // denyAll premet de bloquer les url 
		} else {
			http.formLogin() ;
			http.authorizeRequests().antMatchers("/ajouter**", "/modifier**", "/supprimer**", "/update**").hasRole("ADMIN") ;  // Permet de bloquer une URL et redirige vers l'authentification si l'user n'a pas le role neccessaire
			http.authorizeRequests().antMatchers("/ajouter**").hasRole("SUPERVISOR") ;
		}
		
	}
}
