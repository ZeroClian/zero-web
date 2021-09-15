<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.pojo.vo;

import lombok.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ${table.remarks?replace(';', '', 'r')?trim}基本VO, 用于回显
 * @author ${author}
 * @version ${version}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ${className}VO {

	<@generateVoFields table/>

}
