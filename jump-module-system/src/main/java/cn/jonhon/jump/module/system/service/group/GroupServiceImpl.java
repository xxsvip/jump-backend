package cn.jonhon.jump.module.system.service.group;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.jonhon.jump.module.system.controller.admin.group.vo.*;
import cn.jonhon.jump.module.system.dal.dataobject.group.GroupDO;
import cn.jonhon.jump.framework.common.pojo.PageResult;
import cn.jonhon.jump.framework.common.pojo.PageParam;
import cn.jonhon.jump.framework.common.util.object.BeanUtils;

import cn.jonhon.jump.module.system.dal.mysql.group.GroupMapper;

import static cn.jonhon.jump.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.jonhon.jump.framework.common.util.collection.CollectionUtils.convertList;
import static cn.jonhon.jump.framework.common.util.collection.CollectionUtils.diffList;
import static cn.jonhon.jump.module.system.enums.ErrorCodeConstants.*;

/**
 * 用户组 Service 实现类
 *
 * @author 中航光电
 */
@Service
@Validated
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Override
    public Long createGroup(GroupSaveReqVO createReqVO) {
        // 插入
        GroupDO group = BeanUtils.toBean(createReqVO, GroupDO.class);
        groupMapper.insert(group);

        // 返回
        return group.getId();
    }

    @Override
    public void updateGroup(GroupSaveReqVO updateReqVO) {
        // 校验存在
        validateGroupExists(updateReqVO.getId());
        // 更新
        GroupDO updateObj = BeanUtils.toBean(updateReqVO, GroupDO.class);
        groupMapper.updateById(updateObj);
    }

    @Override
    public void deleteGroup(Long id) {
        // 校验存在
        validateGroupExists(id);
        // 删除
        groupMapper.deleteById(id);
    }

    @Override
        public void deleteGroupListByIds(List<Long> ids) {
        // 删除
        groupMapper.deleteByIds(ids);
        }


    private void validateGroupExists(Long id) {
        if (groupMapper.selectById(id) == null) {
            throw exception(GROUP_NOT_EXISTS);
        }
    }

    @Override
    public GroupDO getGroup(Long id) {
        return groupMapper.selectById(id);
    }

    @Override
    public PageResult<GroupDO> getGroupPage(GroupPageReqVO pageReqVO) {
        return groupMapper.selectPage(pageReqVO);
    }

}
