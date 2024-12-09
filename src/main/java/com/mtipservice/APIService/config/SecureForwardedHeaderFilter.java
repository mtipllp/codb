package com.mtipservice.APIService.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.ForwardedHeaderFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class SecureForwardedHeaderFilter extends ForwardedHeaderFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		super.doFilterInternal(request, response, new SecureRequestWrappedFilterChain(filterChain));
	}
	
	static class SecureRequestWrappedFilterChain implements FilterChain {

		private final FilterChain delegate;
		SecureRequestWrappedFilterChain(FilterChain delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
			// TODO Auto-generated method stub
			delegate.doFilter(new SecureRequest((HttpServletRequest) request), response);
		}
	}
	
	private static class SecureRequest extends HttpServletRequestWrapper {

		public SecureRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean isSecure() {
			return true;
		}
		
		@Override
		public String getScheme() {
			return "https";
		}
		
		@Override
		public StringBuffer getRequestURL() {
			return new StringBuffer(super.getRequestURI().toString().replaceAll("http://", "https://"));
		}
	}
}
