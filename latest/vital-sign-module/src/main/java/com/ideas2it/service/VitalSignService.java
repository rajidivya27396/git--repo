package com.ideas2it.service;

import java.util.Optional;

import com.ideas2it.dto.VitalSignDto;
import com.ideas2it.entity.ReportClass;

public interface VitalSignService {
	VitalSignDto saveVitalSign(VitalSignDto vitalsign, long id);
	VitalSignDto getVitalSign(long id);
	Optional<ReportClass> getReport(long id);
}
