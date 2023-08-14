package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyServiceImpl;

@RestController
@RequestMapping("/reply")
public class ReplyController {

   @Autowired
   ReplyServiceImpl replyService;
      
   //select
   @PostMapping("/insertreply")
   public void insertReply(@RequestBody ReplyVO vo) {
      replyService.insertReply(vo);
   }
   
   @GetMapping("/getreply")
   public List<ReplyVO> selectAllReply() {
      List<ReplyVO> list = replyService.selectAllReply();
      return list;
   }
   
   @DeleteMapping("/deletereply/{rno}")
   public void deleteReply(@PathVariable String rno) {
      replyService.deleteReply(rno);
   }
}