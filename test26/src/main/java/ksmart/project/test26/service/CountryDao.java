package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository를 적으면 객체가 미리 생성되서 CountryDao를 AutoWired로 객체에 주입할수있음
@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 쿼리 경로를 상수로 입력
	private final String namespace = "ksmart.project.test26.service.CountryMapper.";

	public List<Country> selectCountryList() {
		// selectCountryList 쿼리문 실행후 결과를 List<Country> 타입으로 리턴
		return sqlSessionTemplate.selectList(namespace + "selectCountryList");
	}

	// country insert
	public void insertCountry(Country country) {
		sqlSessionTemplate.insert(namespace + "insertCountry", country);
	}

	// country delete
	public void deleteCountry(int country) {
		sqlSessionTemplate.delete(namespace + "deleteCountry", country);
	}

	// country update
	public List<Country> selectOneCountry(int country) {
		return sqlSessionTemplate.selectList(namespace + "selectOneCountry", country);
	}

	// country one update
	public void updateCountry(Country countryId) {
		sqlSessionTemplate.selectList(namespace + "updateCountry", countryId);
	}
}
