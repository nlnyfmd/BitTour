package util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter {
	
	private String encoding;
	protected FilterConfig filterConfig;
	//���͸� �����ϴ� ��ü ����.
		
	
	public void init(FilterConfig filterConfig) 
	// �Ķ���Ϳ� �Է��� ������ �����ϴ� �޼ҵ�
	
		throws ServletException {
		this.filterConfig=filterConfig;
		//�Է��Ѱɷ� ���Ե�.
		this.encoding=filterConfig.getInitParameter("encoding");
		// �Ķ����
	}
	
	/*
	 * HttpServletRequest ��ü�� web.xml���� ���޵� ����  ���ڵ��� �����ϴ� �޼ҵ�.
	 */	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException,ServletException {
		if(request.getCharacterEncoding()==null) {
			if(encoding!=null) {
				// �� �� �Է°��� �ִٸ�,
				request.setCharacterEncoding(encoding);
				// �ش� Ÿ������ ���ڵ�.
			}
		}
		chain.doFilter(request,response);		
	}
    
	/*
	 *  web.xml���� ���޵� ���ڵ� ���� �ʱ�ȭ�ϴ� �޼ҵ�
	 */
	
	public void destroy() {
		this.encoding=null;
		this.filterConfig=null;
		// ���� null�� �������.
	}	
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig=filterConfig;
	}
}//end of class
