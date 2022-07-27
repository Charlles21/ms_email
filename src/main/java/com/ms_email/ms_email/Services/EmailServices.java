package com.ms_email.ms_email.Services;

import javax.validation.Valid;

import com.ms_email.ms_email.Dtos.EmailDto;

public interface EmailServices {

    public EmailDto sendEmail(@Valid EmailDto emailDto);
}
