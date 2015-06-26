#ifndef __BITOPS_H__
#define __BITOPS_H__

/** Common bit operations class
 *
 * This class implements some usable functions, used in bitio
 * library. All of these functions are declared static, so can
 * be used without class instance creation
 *
 */
class bitops
{

public:

  static const unsigned char BIT_MASK[8];

  /** Set the bit value
   *
   * This function sets the bit value to 1 in memory block pointed
   * with but at the position pos, which is threated as bits offset
   *
   */
  inline static void set_bit(void * buf, unsigned int pos)
  {
    ((unsigned char *) buf)[pos / 8] |= BIT_MASK[pos % 8];
  
    return;
  }

  /** Unset the bit value
   *
   * This function sets the bit value to 0 in memory block pointed
   * with buf at the position pos, which is threated as bits offset
   *
   */
  inline static void unset_bit(void * buf, unsigned int pos)
  {
    ((unsigned char *) buf)[pos / 8] &= ~ BIT_MASK[pos % 8];

    return;
  }

  /** Check the bit value
   *
   * This function checks the bit value in memory block pointed
   * with buf at the position pos, which is threated as bits offset
   *
   */
  inline static bool is_bit_set(const void * buf, unsigned int pos)
  {
    return (((const char *) buf)[pos / 8] & BIT_MASK[pos % 8]) != 0;
  }

};

#endif /* __BITOPS_H__ */
