package com.hr.api.service

import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.api.mapper.EmployeeMapper
import com.hr.api.repository.EmployeeRepository
import com.hr.domain.entity.Employee
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class EmpServiceTest