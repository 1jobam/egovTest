package com.test.board.dao.Impl;

import org.springframework.stereotype.Repository;

import com.test.board.dao.boardDao;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository(value = "boardDao")
public class boardDaoImpl extends EgovAbstractDAO implements boardDao {

}
