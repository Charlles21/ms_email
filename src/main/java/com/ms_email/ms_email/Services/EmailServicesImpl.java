package com.ms_email.ms_email.Services;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms_email.ms_email.Dtos.EmailDto;
import com.ms_email.ms_email.Enum.StatusEmail;
import com.ms_email.ms_email.Model.Email;
import com.ms_email.ms_email.Repository.EmailRepository;

@Service
public class EmailServicesImpl implements EmailServices{
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;
  

    ModelMapper mapper = new ModelMapper();

    @Override
    public EmailDto sendEmail(@Valid EmailDto emailDto) {
        Email email = new Email();
        email = mapper.map(emailDto, Email.class);  
        email.setSenDateEmail(LocalDateTime.now());        
        copyEmailAndSend(email);        
        BeanUtils.copyProperties(emailDto, email);        
        return emailDto;
    }

    private void copyEmailAndSend(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);                
        } catch (MailException e) {
           email.setStatusEmail(StatusEmail.ERROR);
        }finally{
            emailRepository.save(email);
        }
    }
}
