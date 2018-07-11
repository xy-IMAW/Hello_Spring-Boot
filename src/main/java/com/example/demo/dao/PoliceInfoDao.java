/**
 * 
 */
package com.example.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.PoliceInfo;

/**
 * 
 *
 */
public interface PoliceInfoDao extends JpaRepository<PoliceInfo, String>,JpaSpecificationExecutor<PoliceInfo>,Serializable {

}
