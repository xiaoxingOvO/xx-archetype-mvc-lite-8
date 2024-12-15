package cn.xx.mapper;

import cn.xx.domain.dto.XXXDTO;
import cn.xx.domain.po.XXXEntity;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaoxing
 * @desciption TODO
 * @date 2024/12/14
 */
public interface XXXMapper extends IBaseMapper<XXXDTO, XXXEntity> {

    XXXMapper INSTANCE = Mappers.getMapper(XXXMapper.class);

}
