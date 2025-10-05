def solution(today, terms, privacies):
    def to_day(date_str):
        y, m, d=map(int, date_str.split('.'))
        return y*12*28+m*28+d
    
    term_dic={}
    for t in terms:
        kind, months=t.split()
        term_dic[kind]=int(months)
        
    today_=to_day(today)
    
    answer = []
    for i, pri in enumerate(privacies):
        date_str, kind=pri.split()
        collected_days=to_day(date_str)
        expire_day=collected_days+term_dic[kind]*28-1
        if expire_day<today_:
            answer.append(i+1)
    
    return answer