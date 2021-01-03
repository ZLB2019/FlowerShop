package com.zlb.flower_shop.model;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 *
 * 通过java发送邮件
 * @author 罗汝指导
 *
 */

public class Mail {

    public static String SendMail(String UserMail) throws Exception {

        Properties prop = new Properties();

        //开启debug调试，以便在控制台查看
        //prop.setProperty("mail.debug","true");

        //设置邮件服务器主机名
        prop.setProperty("mail.host","smtp.qq.com");

        //发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");

        //发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");

        //开启SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);


        // 创建session
        Session session = Session.getInstance(prop);
        // 通过session得到transport对象
        Transport ts = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        ts.connect("smtp.qq.com","1059954375", "uwmwofzmzabvbdji");//后面的字符是授权码
        // 创建邮件
        VerificationMimeMessage verificationMimeMessage=createSimpleMail(session,UserMail);
        Message message = verificationMimeMessage.getMimeMessage();
        // 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();

        return verificationMimeMessage.getVerification();
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static VerificationMimeMessage createSimpleMail(Session session,String UserMail)throws Exception {

        String RetrunVerificationCode="";       //用来返回验证码
        VerificationMimeMessage verificationMimeMessage =new VerificationMimeMessage();
        String VerificationCode="你用来注册flowerShop的验证码为：";
        Random random=new Random();                                                     //Random类用于生产随机数
        int t=4,temp = 0;
        while(t>0)
        {
            temp =random.nextInt(10);                            //生成[0,10]区间的整数
            VerificationCode=VerificationCode+temp;
            RetrunVerificationCode=RetrunVerificationCode+temp;
            t--;
        }

        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);

        // 指明邮件的发件人
        message.setFrom(new InternetAddress("1059954375@qq.com"));

        // 指明邮件的收件人，如果发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(UserMail));

        // 邮件的标题
        message.setSubject("flowerShop注册验证码");

        // 邮件的文本内容
        message.setContent(VerificationCode, "text/html;charset=GB2312");
        verificationMimeMessage.setMimeMessage(message);
        verificationMimeMessage.setVerification(RetrunVerificationCode);
        // 返回创建好的邮件对象
        return verificationMimeMessage;
    }

}
