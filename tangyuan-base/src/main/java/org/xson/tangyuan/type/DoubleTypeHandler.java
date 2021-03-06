package org.xson.tangyuan.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xson.common.object.XCO;

public class DoubleTypeHandler extends BaseTypeHandler<Double> {

	public final static DoubleTypeHandler instance = new DoubleTypeHandler();

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Double parameter, JdbcType jdbcType) throws SQLException {
		ps.setDouble(i, parameter);
	}

	@Override
	public Double getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getDouble(columnName);
	}

	@Override
	public Double getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getDouble(columnIndex);
	}

	@Override
	public Double getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getDouble(columnIndex);
	}

	@Override
	public void appendLog(StringBuilder builder, Double parameter, DatabaseDialect dialect) {
		// if (DatabaseDialect.MYSQL == dialect) {
		// builder.append(parameter);
		// }
		builder.append(parameter);
	}

	@Override
	public void setResultToXCO(ResultSet rs, String columnName, String property, XCO xco) throws SQLException {
		Double v = getResult(rs, columnName);
		if (null != v) {
			xco.setDoubleValue(property, v.doubleValue());
		}
	}
}
