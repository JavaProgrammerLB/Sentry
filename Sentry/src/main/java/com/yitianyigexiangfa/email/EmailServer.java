package com.yitianyigexiangfa.email;

import com.yitianyigexiangfa.model.Programme;
import com.yitianyigexiangfa.model.User;

public interface EmailServer {

	void sendEmail(User user, Programme pro);
}
