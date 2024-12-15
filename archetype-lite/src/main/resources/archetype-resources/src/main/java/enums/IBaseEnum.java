#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.enums;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author xiaoxing
 * @desciption 枚举公共接口
 * @date 2024/12/14
 */
public interface IBaseEnum {

    /**
     * 根据 code 查找枚举值。
     *
     * @param code      业务编码
     * @param enumClass 枚举类的 Class 对象
     * @param <E>       枚举类型，必须实现 IBaseEnum 接口
     * @return 匹配的枚举值，若未找到则返回 null
     */
    static <E extends Enum<E> & IBaseEnum> E fromCode(Object code, Class<E> enumClass) {
        if (code == null) {
            return null;
        }
        return Stream.of(enumClass.getEnumConstants())
                .filter(e -> Objects.equals(code, e.getCode()))
                .findFirst()
                .orElse(null);
    }

    /**
     * 根据 desc 查找枚举值。
     *
     * @param desc      枚举的描述
     * @param enumClass 枚举类的 Class 对象
     * @param <E>       枚举类型，必须实现 IBaseEnum 接口
     * @return 匹配的枚举值，若未找到则返回 null
     */
    static <E extends Enum<E> & IBaseEnum> E fromDesc(Object desc, Class<E> enumClass) {
        if (desc == null) {
            return null;
        }
        return Stream.of(enumClass.getEnumConstants())
                .filter(e -> Objects.equals(desc, e.getDesc()))
                .findFirst()
                .orElse(null);
    }

    /**
     * 获取枚举的描述。
     *
     * @return 枚举的描述，默认返回 null，可在实现类中重写
     */
    default Object getCode() {
        return null;
    }

    /**
     * 获取枚举的描述。
     *
     * @return 枚举的描述，默认返回 null，可在实现类中重写
     */
    default Object getDesc() {
        return null;
    }
}
