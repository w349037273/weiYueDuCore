import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-12-02
 * 时间: 15:39
 */
public class HttpRequestor {


    private String charset = "utf-8";//设置请求字符编码

    private Integer connectionTimeout = null;//设置链接超时时间

    private Integer socketTimeout = null;//设置套接字超时时间

    private String proHost = null;//代理主机

    private Integer proPort = null;//代理主机端口号


    public static void main(String[] args) {
        HttpRequestor httpRequestor = new HttpRequestor();

        try {
            String s = httpRequestor.doGet("http://www.baidu.com");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 模拟get请求
     * @param url
     * @return
     */
    public String doGet(String url) throws Exception {

        URL localURL = new URL(url);

        //获取url链接
        URLConnection urlConnection = this.openConnection(localURL);
        //强转为httpurlconnection
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

        InputStream inputStream = null;//响应流
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String temLine = null;

        //响应失败
        if (httpURLConnection.getResponseCode() >= 300){
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }
        try {
            //处理响应
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            //读取响应
            while ((temLine = (reader.readLine())) != null){
                resultBuffer.append(temLine);
            }

        }finally {

            if (reader != null){
                reader.close();
            }

            if (inputStreamReader != null){
                inputStreamReader.close();
            }

            if (inputStream != null){
                inputStream.close();
            }

        }
        return resultBuffer.toString();
    }




    /**
     * 获取http链接请求
     * @param locaURL
     * @return
     * @throws IOException
     */
    private URLConnection openConnection(URL locaURL) throws IOException {

        URLConnection urlConnection;
        if (proHost != null && proPort != null){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proHost,proPort));
            urlConnection = locaURL.openConnection(proxy);
        }else {
            urlConnection = locaURL.openConnection();
        }
        return urlConnection;
    }


    /**
     * 模拟post请求
     * @param url
     * @param parameterMap
     * @return
     * @throws Exception
     */
    public String doPost(String url, Map parameterMap) throws Exception {

        StringBuffer parameterBuffer = new StringBuffer();
        if (parameterMap != null && parameterMap.size() >0){
            Iterator iterator = parameterMap.keySet().iterator();
            String key = null;
            String value = null;
            while (iterator.hasNext()){

                key = String.valueOf(iterator.next());
                if (parameterMap.get(key) != null){
                    value = String.valueOf(parameterMap.get(key));
                }else {
                    value = "";
                }

                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()){
                    parameterBuffer.append("&");
                }
            }
        }

        //创建http链接
        URL localURL = new URL(url);
        URLConnection urlConnection = this.openConnection(localURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

        //设置请求头
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset",charset);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));

        //读取响应资源
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String templine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(parameterBuffer.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300){
                throw new Exception("出错啦");
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((templine = reader.readLine()) != null){
                resultBuffer.append(templine);
            }
        }finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

        return resultBuffer.toString();
    }


    /**
     * 渲染请求,增加链接请求超时时间或套接字超时时间
     * @param conn
     */
    private void renderRequest(URLConnection conn){
        if (connectionTimeout != null){
            conn.setConnectTimeout(connectionTimeout);
        }

        if (socketTimeout != null){
            conn.setReadTimeout(socketTimeout);
        }


    }



    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getProHost() {
        return proHost;
    }

    public void setProHost(String proHost) {
        this.proHost = proHost;
    }

    public Integer getProPort() {
        return proPort;
    }

    public void setProPort(Integer proPort) {
        this.proPort = proPort;
    }
}
