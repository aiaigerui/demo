package demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class IpIpController {

    @GetMapping("isZhIp")
    public boolean isZhIp(HttpServletRequest request) {
        String ip = getHost(request);
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            return true;
        }

        MultiValueMap<String, String> requestHeaders = new HttpHeaders();
        //伪装浏览器访问
        requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");

        requestHeaders.add("Token", "");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity;
        try {
            System.out.println(ip);
            responseEntity = restTemplate.exchange("http://ipapi.ipip.net/find?addr=" + ip,
                    HttpMethod.GET, requestEntity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        String content = responseEntity.getBody();

        JSONObject json = new JSONObject(content);
        String ret = json.getString("ret");

        if (!"ok".equalsIgnoreCase(ret)) {
            return true;
        }

        JSONArray array = json.getJSONArray("data");
        if (array != null && array.length() > 0) {
            String countryCode = array.getString(array.length() - 2);
            if (!"CN".equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }

    public static final String getHost(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip)) {
            InetAddress inet = null;
            try { // 根据网卡取本机配置的IP
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            ip = inet.getHostAddress();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }
}
