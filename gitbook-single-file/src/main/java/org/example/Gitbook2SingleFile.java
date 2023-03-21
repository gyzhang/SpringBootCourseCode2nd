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
 * 将一整本gitbook书输出到一个单一的文件
 * 约定书中使用的图片，统一都是在“./images”目录下
 * 也就是说存放生成单一xxx.md文件的目录中有一个子目录“./images”，其下存放了这本gitbook的所有图片文件
 */
public class Gitbook2SingleFile {

    public static void main(String[] args) throws IOException {
        int mdFileCount = 0;
        int imgFileCount = 0;
        String gitbookPath = "C:\\Users\\Kevin Zhang\\MyBooks\\SpringBootCourse2nd";
        String summaryName = "SUMMARY.md";
        String summaryFileName = gitbookPath + System.getProperty("file.separator") + summaryName;

        String gitbookSigleFilePath = "D:\\temp\\mdtest";
        String imagesBasePath = gitbookSigleFilePath + System.getProperty("file.separator") + "images";
        String gitbookSigleFile =
            gitbookSigleFilePath + System.getProperty("file.separator") + "SpringBoot从入门到实战：第2版.md";
        File gitbookDir = new File(imagesBasePath);
        gitbookDir.mkdirs();

        Writer gitbook = new BufferedWriter(new FileWriter(gitbookSigleFile));

        List<GitbookSummaryBean> list = GitbookSummaryUtil.readLines(new File(summaryFileName));
        for (GitbookSummaryBean bean : list) {
            String mdFileAbsolutePath = gitbookPath + System.getProperty("file.separator") + bean.getMarkdownFile();
            mdFileCount++;

            List<String> lines = MarkdownFileUtil.readLines(new File(mdFileAbsolutePath));//获取MD文件的内容
            Map<Integer, MarkdownImageBean> imgs = MarkdownFileUtil.readImageLines(lines);// 获取MD源文件中的图片标记
            System.out.println(bean.getMarkdownFile() + "，" + lines.size() + "行，" + imgs.size() + "个图片");
            //拷贝gitbook中的图片
            for (MarkdownImageBean img : imgs.values()) {
                String imgFileFrom =
                    mdFileAbsolutePath.substring(0, mdFileAbsolutePath.indexOf('/')) + System.getProperty("file.separator")
                        + img.getUrl();
                String imgFileTo = gitbookSigleFilePath + System.getProperty("file.separator") + img.getUrl();
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
            "GitBook[MD文件" + mdFileCount + "个，图片" + imgFileCount + "个]转换单一文件已完成：" + gitbookSigleFile);
    }
}
