package cn.xx.mapper;

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
