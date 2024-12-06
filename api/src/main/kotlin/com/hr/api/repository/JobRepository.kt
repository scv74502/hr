package com.hr.api.repository

import com.hr.domain.entity.Job
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JobRepository : JpaRepository<Job, String> {
    fun findJobByJobId(jobId: String): Job?
}
