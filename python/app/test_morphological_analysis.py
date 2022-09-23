"""
헤드라인을 엔터를 기준으로 입력하여 테스트 파일 생성
text : keyword has news 테이블에 들어갈 내용
file : hadoop wordcount 처리용
"""

from app import keyword_processing as keyproc, morphological_analysis as morph

i = 1
text = []
while True :
    line = input()
    if line == '':
        break
    else:
        text.append(tuple([line, i]))
        i += 1
text = tuple(text)
print(text)

analysis_result = morph.morphological_analysis(text)
print(analysis_result)
keyproc.save_as_file(analysis_result)