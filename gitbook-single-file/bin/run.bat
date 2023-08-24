:: 设置代码页为UTF-8，避免中文乱码
chcp 65001
:: 需要3个参数，1=gitbook的目录，2=合并后单一md文件的地址，3=合并后单一md文件名称
java -Dfile.encoding=UTF-8 -jar MarkDownBook.jar "C:\\Users\\Kevin Zhang\\MyGithub\\poc-howto\\信贷2.0部署手册\\POC部署练习用手册" "D:\\temp\\mdbook" "NCPm2.0.md"