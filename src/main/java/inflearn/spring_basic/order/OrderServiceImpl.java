package inflearn.spring_basic.order;

import inflearn.spring_basic.discount.DiscountPolicy;
import inflearn.spring_basic.discount.FixDiscountPolicy;
import inflearn.spring_basic.discount.RateDiscountPolicy;
import inflearn.spring_basic.member.Member;
import inflearn.spring_basic.member.MemberRepository;
import inflearn.spring_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

  //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
