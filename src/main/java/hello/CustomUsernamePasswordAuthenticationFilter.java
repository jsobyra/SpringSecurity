package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.logging.Logger;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static Logger logger = Logger.getLogger(CustomUsernamePasswordAuthenticationFilter.class.toString());

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            BufferedReader reader = request.getReader();
            StringBuffer sb = new StringBuffer();
            String line = null;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String parsedReq = sb.toString();
            AuthReq authReq = null;
            if(parsedReq != null) {
                ObjectMapper mapper = new ObjectMapper();
                authReq = mapper.readValue(parsedReq, AuthReq.class);
            }
            return new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InternalAuthenticationServiceException("Failed to parse");
        }
    }
}
