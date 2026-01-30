package cn.jonhon.jump.module.system.dal.mysql.group;

import java.util.*;

import cn.jonhon.jump.framework.common.pojo.PageResult;
import cn.jonhon.jump.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.jonhon.jump.framework.mybatis.core.mapper.BaseMapperX;
import cn.jonhon.jump.module.system.dal.dataobject.group.GroupDO;
import org.apache.ibatis.annotations.Mapper;
import cn.jonhon.jump.module.system.controller.admin.group.vo.*;

/**
 * 用户组 Mapper
 *
 * @author 中航光电
 */
@Mapper
public interface GroupMapper extends BaseMapperX<GroupDO> {

    default PageResult<GroupDO> selectPage(GroupPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GroupDO>()
                .likeIfPresent(GroupDO::getName, reqVO.getName())
                .eqIfPresent(GroupDO::getDescription, reqVO.getDescription())
                .eqIfPresent(GroupDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GroupDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GroupDO::getId));
    }

}
