package com.kx.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
public class HttpClient {
	static final String CHARSET = "UTF-8"; 
	/**
     * POST方式发起http请求
     */
    public String httppost(String url,Map<String,String> dataMap){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);          //这里用上本机的某个工程做测试
            //创建参数列表
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(Entry<String, String> entry:dataMap.entrySet()){
            	list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
//            list.add(new BasicNameValuePair("j_username", "admin"));
//            list.add(new BasicNameValuePair("j_password", "admin"));
            //url格式编码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"UTF-8");
            post.setEntity(uefEntity);
            System.out.println("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try{
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    System.out.println("-------------------------------------------------------");
                    System.out.println(EntityUtils.toString(uefEntity));
                    System.out.println("-------------------------------------------------------");
                	return EntityUtils.toString(uefEntity);
//                	entity.getContent()
                }
            } finally{
                httpResponse.close();
            }
             
        } catch( UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
            	if (httpClient != null){
            		httpClient.close();
                }            
            } catch(Exception e){
                e.printStackTrace();
            }
        }
         return null;
    }
	public String sendGet(String httpurl,String charset) throws IOException{
		String content ="";
		URL url = new URL(httpurl);
		URLConnection conn = url.openConnection(); 
		conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		//10S 超时
		conn.setConnectTimeout(10000);
		InputStream is = conn.getInputStream(); 
		byte[] bts = new byte[2048]; 
		ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
		int n; 
		while ((n = is.read(bts)) != -1) { 
			content+= new String(bts,charset);
			bts = new byte[2048]; 
		}
		return content;
	}
	public String httpGet(String httpurl,String charset){
		CloseableHttpClient httpclient = HttpClients.createDefault();
//		httpclient.getParams().setIntParameter("http.socket.timeout", 10000);
        try {  
            // 创建httpget.    
            HttpGet httpget = new HttpGet(httpurl);  
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpget);  
            try {  
                // 获取响应实体    
                HttpEntity entity = response.getEntity();  
                // 打印响应状态    
                if (entity != null) {  
                    // 打印响应内容长度    
                   // System.out.println("Response content length: " + entity.getContentLength());  
                    // 打印响应内容    
                  //  System.out.println("Response content: " + EntityUtils.toString(entity));  
                	return EntityUtils.toString(entity);
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
           // e.printStackTrace();  
        } catch (ParseException e) {  
           // e.printStackTrace();  
        } catch (IOException e) {  
           // e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } 
        return null;
	}
	public static String sendPost(String url, String param) {
		System.out.println(url);
		System.out.println(param);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),CHARSET));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }   
	public static void main(String[] args) {
		HttpClient httpClient = new HttpClient();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", "123132");
		String content = httpClient.httpGet("http://stock.gtimg.cn/data/view/bdrank.php?&t=01/averatio&p=1&o=0&l=200&v=list_data", "gbk");
		System.out.println(content);
		content = content.substring(content.indexOf("data:'")+6,content.lastIndexOf("'"));

	
	}
}
