package com.jimrennie.junit.world2.boss;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditTrail {

	public void audit(AuditType auditType) {
		log.info("Audit - {}", auditType);
	}

}
