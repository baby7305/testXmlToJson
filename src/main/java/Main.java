import FTP.FtpUtils;

public class Main {
    public static void main(String[] args) {
        FtpUtils ftp = new FtpUtils();
        //ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
        //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
//        ftp.deleteFile("ftpFile/data", "123.docx");
        ftp.downloadFile("ftpFile", "AA.png", "E://");
        System.out.println("ok");
    }
}
