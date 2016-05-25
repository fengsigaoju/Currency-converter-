import urllib
import urllib2
import re
import sys
reload(sys)
sys.setdefaultencoding( "utf-8" )
url="http://www.boc.cn/sourcedb/whpj/";
spath="E://1.txt"
f=open(spath,"w")
user_agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36"
headers = { 'User-Agent' : user_agent}  
request=urllib2.Request(url,None,headers);
response =urllib2.urlopen(request)
content=response.read().decode("utf-8")
#f.write(content)
result = re.findall('(?<=<td>).+?(?=</td>)',content)
f.write(result[178]+"\n")
#f.write(cj)
f.close()
    

    
