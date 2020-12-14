package com.ideas2it.vitalsignmodule.service;

import java.util.List;

import com.ideas2it.vitalsignmodule.dto.VitalSignDto;

public interface VitalSignService {
	VitalSignDto saveVitalSign(VitalSignDto vitalsign, long id);
	VitalSignDto getVitalSign(long id);
}
