package org.example;

import org.example.gitbook.GitbookSummaryBean;
import org.example.gitbook.GitbookSummaryUtil;
import org.example.gitbook.MarkdownFileUtil;
import org.example.gitbook.MarkdownImageBean;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

/**
 * 将一整本gitbook书输出到一个单一的文件 约定书中使用的图片，统一都是在“./images”目录下 也就是说存放生成单一xxx.md文件的目录中有一个子目录“./images”，其下存放了这本gitbook的所有图片文件
 */
public class Gitbook2SingleFile {

    public static final String FILE_SEPATATOR = System.getProperty("file.separator");

    public static void main(String[] args) throws IOException {
        String gitbookPath = "C:\\Users\\Kevin Zhang\\MyGithub\\poc-howto\\信贷2.0部署手册\\POC部署练习用手册";
        String gitbookSigleFilePath = "D:\\temp\\mdbook";
        String singleFileName = "综合信贷2.0产品可控POC部署手册.md";
        //如果传入的参数大于等于2个，则取第1个为gitbook的目录，第2个为合并的单一markdown文件的目录
        if (args.length >= 3) {
            gitbookPath = args[0];
            gitbookSigleFilePath = args[1];
            singleFileName = args[2];
        }

        int mdFileCount = 0;
        int imgFileCount = 0;
        String summaryName = "SUMMARY.md"; //这个文件中必须以/来标记章节md文件，如./abc.md（和summary.md同级目录）或abc/xyz.md（summary.md夏季abc目录）
        String summaryFileName = gitbookPath + FILE_SEPATATOR + summaryName;
        String imagesBasePath = gitbookSigleFilePath + FILE_SEPATATOR + "images";
        String gitbookSigleFile = gitbookSigleFilePath + FILE_SEPATATOR + singleFileName;
        File gitbookDir = new File(imagesBasePath);
        gitbookDir.mkdirs();

        Writer gitbook = new BufferedWriter(new FileWriter(gitbookSigleFile));

        List<GitbookSummaryBean> list = GitbookSummaryUtil.readLines(new File(summaryFileName));
        for (GitbookSummaryBean bean : list) {
            String mdFileAbsolutePath = gitbookPath + FILE_SEPATATOR + bean.getMarkdownFile();
            mdFileCount++;

            List<String> lines = MarkdownFileUtil.readLines(new File(mdFileAbsolutePath));//获取MD文件的内容
            Map<Integer, MarkdownImageBean> imgs = MarkdownFileUtil.readImageLines(lines);// 获取MD源文件中的图片标记
            System.out.println(bean.getMarkdownFile() + "，" + lines.size() + "行，" + imgs.size() + "个图片");
            //拷贝gitbook中的图片
            for (MarkdownImageBean img : imgs.values()) {
                String imgFileFrom =
                    mdFileAbsolutePath.substring(0, mdFileAbsolutePath.indexOf('/')) + FILE_SEPATATOR + img.getUrl();
                String imgFileTo = gitbookSigleFilePath + FILE_SEPATATOR + img.getUrl();
                Files.copy(new File(imgFileFrom).toPath(), new File(imgFileTo).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
                imgFileCount++;
            }
            //添加每个md文件中的行
            for (String line : lines) {
                gitbook.append(line);
                gitbook.append(System.lineSeparator());
            }
        }

        gitbook.close();
        System.out.println(
            "===================================================================================================");
        System.out.println(
            "GitBook[MD文件" + mdFileCount + "个，图片" + imgFileCount + "个]转换单一文件已完成：" + gitbookSigleFile);
    }
}
