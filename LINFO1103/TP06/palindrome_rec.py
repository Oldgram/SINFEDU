def is_palindrome_rec(s):
    """
    pre: `s` est un str
    post: détermine récursivement si `s` est un palindrome ou non
    """
    if len(s) < 2:
        return True

    if s[0] != s[-1]:
        return False

    return is_palindrome_rec(s[1:-1])


# Exemple de test:
if not is_palindrome_rec("kayak"):
    print("Erreur : kayak est un palindrome")
if is_palindrome_rec("yWAcqFGzYtEw"):
    print("Erreur : yWAcqFGzYtEw n'est pas un palindrome")
