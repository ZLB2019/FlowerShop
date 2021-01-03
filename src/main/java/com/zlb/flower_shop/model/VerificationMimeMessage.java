package com.zlb.flower_shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.mail.internet.MimeMessage;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationMimeMessage {
    private MimeMessage mimeMessage;
    private String Verification;
}
