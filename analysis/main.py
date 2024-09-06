import os
import subprocess

def rodar_escalonador(quantum : int):
    with open(file="programas/quantum.txt", mode='w') as r:
        r.write(f"{quantum}")
    subprocess.call(['java', '-jar', 'escalonador.jar'])
    r.close()

def get_log_info(path : str):
    with open(file=path, mode='r') as s:
        lines = s.readlines()
        media_trocas = lines[-3].split(" ")[-1].replace('\n', '')
        media_instrucoes = lines[-2].split(" ")[-1].replace('\n', '')
        quantum = lines[-1].split(" ")[-1].replace('\n', '')

    s.close()
    return (media_trocas, media_instrucoes, quantum)

quantums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

for i in range(1, 22):
    rodar_escalonador(i)

with open("out.csv", "w") as w:
    w.write("MEDIA_TROCAS,MEDIA_INSTRUCOES,QUANTUMS\n")
    for log in os.listdir("logs"):
        media_trades, media_instructions, quanton = get_log_info(f"logs/{log}")
        w.write(f"{media_trades},{media_instructions},{quanton}\n")

w.close()