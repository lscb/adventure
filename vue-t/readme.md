一个简单的vue.js项目<br />
调用百度地图api以及 加载百度地图的热力图<br />
用了nginx解决跨域问题

nginx 配置
/conf/nginx.conf
<code>  


#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;


    sendfile        on;

    keepalive_timeout  65;

    server {
        listen       80;
        server_name  localhost;
		
        location / {
			#root 下放vue.JS打包出来的存放静态文件dist文件目录   或者  直接把打包出来的dist下的文件拷到nginx默认目录下
            root   D:/gitRepository/vue-t/dist;
            index  index.html;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
		
		#这里重写/api
		 location /api {
		 rewrite  ^.+api/?(.*)$ /$1 break;
		 include  uwsgi_params;
		 proxy_pass   http://127.0.0.1:8001;
		 }

    }

}
</code>