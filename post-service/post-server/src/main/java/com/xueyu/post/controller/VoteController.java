package com.xueyu.post.controller;

import com.xueyu.common.core.result.RestResult;
import com.xueyu.post.pojo.domain.Vote;
import com.xueyu.post.pojo.vo.VoteVO;
import com.xueyu.post.service.VoteService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("post/vote")
public class VoteController {

    @Resource
    VoteService voteService;

    /**
     * 发起投票
     *
     * @param vote    投票
     * @param options 选项
     * @return {@link RestResult}<{@link ?}>
     */
    @PostMapping("launch")
    public RestResult<?> launchVote(Vote vote, String[] options){
        boolean status = voteService.launchVote(vote,options);
        if(!status){
            return RestResult.fail("发布投票失败");
        }
        return RestResult.ok("发布成功");
    }

    /**
     * 删除投票
     *
     * @param voteId 投票id
     * @return {@link RestResult}<{@link ?}>
     */
    @PostMapping("delete")
    public RestResult<?> deleteVote(Integer voteId){
        boolean status = voteService.deleteVote(voteId);
        if(!status){
            return RestResult.fail("删除投票失败");
        }
        return RestResult.ok("删除投票成功");
    }

    /**
     * 获得投票信息
     *
     * @param postId post id
     * @return {@link RestResult}<{@link VoteVO}>
     */
    @GetMapping("getone")
    public RestResult<VoteVO> getVoteDetail(@RequestParam Integer postId){
        return RestResult.ok(voteService.getVoteDetail(postId));
    }

}
