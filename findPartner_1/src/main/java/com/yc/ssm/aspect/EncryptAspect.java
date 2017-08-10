package com.yc.ssm.aspect;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.yc.ssm.entity.Administrator;
import com.yc.ssm.entity.Login;
import com.yc.ssm.util.Encrypt;

@Component("encryptAspect")
@Aspect
public class EncryptAspect {
	// com.yc.ssm.service.impl.LoginServiceImpl
	@Before("execution(* com.yc.ssm.service.impl.LoginServiceImpl.login(..))")
	public void beforeMethodlogin(JoinPoint jpoint) {
		Login login = (Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + login);
		login.setPassword(Encrypt.md5AndSha(login.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.LoginServiceImpl.register(..))")
	public void beforeMethodregister(JoinPoint jpoint) {
		Login login = (Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + login);
		login.setPassword(Encrypt.md5AndSha(login.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.LoginServiceImpl.updatePwd(..))")
	public void beforeMethodModifyPwd(JoinPoint jpoint) {
		Login login = (Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + login);
		login.setPassword(Encrypt.md5AndSha(login.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.LoginServiceImpl.updateNewPwd(..))")
	public void beforeMethodupdateNewPwd(JoinPoint jpoint) {
		Login login = (Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + login);
		login.setPassword(Encrypt.md5AndSha(login.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.AdministratorServiceImpl.adminLogin(..))")
	public void beforeMethodAdminLogin(JoinPoint jpoint) {
		Administrator admin = (Administrator) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + admin);
		admin.setBapwd(Encrypt.md5AndSha(admin.getBapwd()));
		LogManager.getLogger().debug("对密码加密后==》" + admin);
	}
}
