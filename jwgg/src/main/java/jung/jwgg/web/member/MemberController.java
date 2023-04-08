package jung.jwgg.web.member;

import jung.jwgg.domain.member.Member;
import jung.jwgg.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {

        if (memberRepository.findByLoginId(member.getLoginId()).isPresent()) {
            bindingResult.reject("loginIdExist","이미 존재하는 아이디 입니다.");
        }

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        if (memberRepository.findByName(member.getName()).isPresent()) {
            bindingResult.reject("loginNameExist","이미 존재하는 이름 입니다.");
        }

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        memberRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editForm(@ModelAttribute("member") Member member) {
        return "members/editMemberForm";
    }



}
