<#assign className = table.className>
package ${basepackage}.repository;

import ${basepackage}.pojo.entity.${className};
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${table.remarks?replace(';', '', 'r')?trim} ζδΉεε±
 * @author ${author}
 * @version ${version}
 */
public interface ${className}Repository extends JpaRepository<${className}, Integer> {


}
