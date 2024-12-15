#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import java.util.List;

/**
 * @author xiaoxing
 * @desciption mapper公共父类
 * @date 2024/12/14
 */
public interface IBaseMapper<D,E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

}
