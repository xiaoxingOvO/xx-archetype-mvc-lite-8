#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import ${package}.domain.dto.XXXDTO;
import ${package}.domain.po.XXXEntity;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaoxing
 * @desciption TODO
 * @date 2024/12/14
 */
public interface XXXMapper extends IBaseMapper<XXXDTO, XXXEntity> {

    XXXMapper INSTANCE = Mappers.getMapper(XXXMapper.class);

}
