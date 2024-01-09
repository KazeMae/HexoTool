package org.KazeMae;

import java.io.IOException;

public class BashControl {


    private final String path = "d:\\HexoBlog"; // 你的 hexo 根目录

    public BashControl() {

    }

    public void newPost(String title) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c cd " + (path.charAt(0) == 'C' || path.charAt(0) == 'c' ? "" : "/" + path.charAt(0)) + " " + path + " && hexo new \"" + title + "\" && explorer " + path + "\\source\\_posts");
    }

    public void newPage(String title) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c cd " + (path.charAt(0) == 'C' || path.charAt(0) == 'c' ? "" : "/" + path.charAt(0)) + " " + path + " && hexo newpage \"" + title + "\" && explorer " + path + "\\source");
    }

    public void submit() throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c cd " + (path.charAt(0) == 'C' || path.charAt(0) == 'c' ? "" : "/" + path.charAt(0)) + " " + path + " && hexo g -d");
    }
}
